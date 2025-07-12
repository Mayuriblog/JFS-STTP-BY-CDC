

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
@WebServlet("/distance")
public class DistanceServlet extends HttpServlet {

    // 🔑 Paste your ORS API key below
    private final String apiKey = "eyJvcmciOiI1YjNjZTM1OTc4NTExMTAwMDFjZjYyNDgiLCJpZCI6IjQyZGQ2NmVlMDJlZDQwMTQ4ZTc1ODgwZDBlZjY0OWIyIiwiaCI6Im11cm11cjY0In0=";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");

        try {
            double[] sourceCoords = getCoordinates(source);
            double[] destCoords = getCoordinates(destination);
            double distance = getDistance(sourceCoords, destCoords);

            request.setAttribute("distance", distance);
            request.setAttribute("source", source);
            request.setAttribute("destination", destination);

            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    private double[] getCoordinates(String location) throws IOException {
        String geocodeUrl = "https://api.openrouteservice.org/geocode/search?api_key=" + apiKey +
                "&text=" + URLEncoder.encode(location, "UTF-8");

        URL url = new URL(geocodeUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) json.append(line);
        reader.close();

        JSONObject obj = new JSONObject(json.toString());
        JSONArray features = obj.getJSONArray("features");
        JSONArray coordinates = features.getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates");

        return new double[]{coordinates.getDouble(0), coordinates.getDouble(1)}; // [lon, lat]
    }

    private double getDistance(double[] src, double[] dest) throws IOException {
        String jsonInput = String.format("{\"coordinates\":[[%f,%f],[%f,%f]]}", 
                                src[0], src[1], dest[0], dest[1]);

        URL url = new URL("https://api.openrouteservice.org/v2/directions/driving-car");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", apiKey);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        OutputStream os = conn.getOutputStream();
        os.write(jsonInput.getBytes());
        os.flush();
        os.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder json = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) json.append(line);
        reader.close();

        JSONObject obj = new JSONObject(json.toString());
        return obj.getJSONArray("routes")
                  .getJSONObject(0)
                  .getJSONObject("summary")
                  .getDouble("distance") / 1000.0; // convert meters to kilometers
    }
}
