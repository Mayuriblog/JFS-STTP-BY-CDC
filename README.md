E:\JFS_STTP_BY_CDC>git init

Initialized empty Git repository in E:/JFS_STTP_BY_CDC/.git/

E:\JFS_STTP_BY_CDC>git add *.*     

E:\JFS_STTP_BY_CDC>git commit -m "day 1"

[master (root-commit) 5e8a80b] day 1
 15 files changed, 220 insertions(+)
 create mode 100644 CONTENT JFS.docx
 create mode 100644 FIRSTPROJECT/.gitignore
 create mode 100644 FIRSTPROJECT/.idea/.gitignore
 create mode 100644 FIRSTPROJECT/.idea/encodings.xml
 create mode 100644 FIRSTPROJECT/.idea/misc.xml
 create mode 100644 FIRSTPROJECT/pom.xml
 create mode 100644 FIRSTPROJECT/src/main/java/SampleDemo/Sample.java
 create mode 100644 FIRSTPROJECT/src/main/java/org/example/Main.java
 create mode 100644 PROJECT1/.gitignore
 create mode 100644 PROJECT1/.idea/.gitignore
 create mode 100644 PROJECT1/.idea/misc.xml
 create mode 100644 PROJECT1/pom.xml
 create mode 100644 PROJECT1/src/main/java/DAY1_Session/SampleDemo.java
 create mode 100644 PROJECT1/src/main/java/org/example/Main.java
 create mode 100644 ~$NTENT JFS.docx

E:\JFS_STTP_BY_CDC>git remote add origin https://github.com/Mayuriblog/JFS-STTP-BY-CDC.git

E:\JFS_STTP_BY_CDC>git push origin master

fatal: credential-cache unavailable; no unix socket support
Enumerating objects: 27, done.
Counting objects: 100% (27/27), done.
Delta compression using up to 4 threads
Compressing objects: 100% (18/18), done.
Writing objects: 100% (27/27), 14.97 KiB | 2.99 MiB/s, done.
Total 27 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), done.
remote:
remote: Create a pull request for 'master' on GitHub by visiting:
remote:      https://github.com/Mayuriblog/JFS-STTP-BY-CDC/pull/new/master
remote:
To https://github.com/Mayuriblog/JFS-STTP-BY-CDC.git
 * [new branch]      master -> master

E:\JFS_STTP_BY_CDC>
-------------------------------------------------after including some content or files in local folder------------------------

E:\JFS_STTP_BY_CDC>git status

On branch master
Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   CONTENT JFS.docx
        deleted:    ~$NTENT JFS.docx

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        Exception Handling.txt
        Flyer .png
        Schedule.pdf

no changes added to commit (use "git add" and/or "git commit -a")

E:\JFS_STTP_BY_CDC>git add *.*


E:\JFS_STTP_BY_CDC>git commit -m "day 1"

[master a32e065] day 1
 5 files changed, 40 insertions(+)
 create mode 100644 Exception Handling.txt
 create mode 100644 Flyer .png
 create mode 100644 Schedule.pdf
 delete mode 100644 ~$NTENT JFS.docx

E:\JFS_STTP_BY_CDC>git push origin master

fatal: credential-cache unavailable; no unix socket support
To https://github.com/Mayuriblog/JFS-STTP-BY-CDC.git
 ! [rejected]        master -> master (fetch first)
error: failed to push some refs to 'https://github.com/Mayuriblog/JFS-STTP-BY-CDC.git'
hint: Updates were rejected because the remote contains work that you do
hint: not have locally. This is usually caused by another repository pushing
hint: to the same ref. You may want to first integrate the remote changes
hint: (e.g., 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

E:\JFS_STTP_BY_CDC>git pull origin master

remote: Enumerating objects: 7, done.
remote: Counting objects: 100% (7/7), done.
remote: Compressing objects: 100% (6/6), done.
remote: Total 6 (delta 3), reused 0 (delta 0), pack-reused 0 (from 0)
Unpacking objects: 100% (6/6), 2.45 KiB | 114.00 KiB/s, done.
From https://github.com/Mayuriblog/JFS-STTP-BY-CDC
 * branch            master     -> FETCH_HEAD
   5e8a80b..dff9a05  master     -> origin/master
Merge made by the 'ort' strategy.
 README.md | 46 ++++++++++++++++++++++++++++++++++++++++++++++
 1 file changed, 46 insertions(+)
 create mode 100644 README.md

E:\JFS_STTP_BY_CDC>git push origin master

fatal: credential-cache unavailable; no unix socket support
Enumerating objects: 12, done.
Counting objects: 100% (11/11), done.
Delta compression using up to 4 threads
Compressing objects: 100% (8/8), done.
Writing objects: 100% (8/8), 3.82 MiB | 4.78 MiB/s, done.
Total 8 (delta 2), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (2/2), completed with 1 local object.
To https://github.com/Mayuriblog/JFS-STTP-BY-CDC.git
   dff9a05..9aa04de  master -> master

E:\JFS_STTP_BY_CDC>











