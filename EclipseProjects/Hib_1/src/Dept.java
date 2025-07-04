import java.util.List;
import java.util.Objects;

public class Dept {
       private int deptNo;
       private String deptName;
       private String loc;
       private List<Emp> empList;
       public Dept() {
   		super();
   		// TODO Auto-generated constructor stub
   	}
	public Dept(int deptNo, String deptName, String location, List<Emp> empList) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.loc = loc;
		this.empList = empList;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	@Override
	public int hashCode() {
		return Objects.hash(deptName, deptNo, loc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dept other = (Dept) obj;
		return Objects.equals(deptName, other.deptName) && deptNo == other.deptNo
				&& Objects.equals(loc, other.loc);
	}
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptName=" + deptName + ", location=" + loc + "]";
	}
	
	
}
