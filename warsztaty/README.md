# WEB APP: "E-book store"

# TABLE OF CONTENT

1. Description
2. System Requirements
3. Technologies
4. Deploying the application
5. Importing the project into an IDE

---

1. DESCRIPTION

---

This is the web store where you can buy some e-books. You can register, log in, choose interesting e-book and buy it! 
One or more. But first you have to pass all validation provided in the registery form. 
If you have permission, you can log as admin and check all orders and clients. 
All this done in JFS, styled in CSS. Run and enjoy!

2. SYSTEM REQUIREMENTS

---

All you need to build this project is Java 17.0 (Java SDK 1.6) or better, Maven
3.0 or better.

The application this project produces is designed to be run on a JBoss AS 6.

NOTE:
This project some retrieves artifacts from the JBoss Community Maven repository.

With the prerequisites out of the way, you're ready to build and deploy.

3. TECHNOLOGIES

---

- JSF
- HTML/CSS
- MySQL database

4. DEPLOYING THE APPLICATION

---

First you need to start JBoss AS 6. To do this, run

    $JBOSS_HOME/bin/standalone.sh

or if you are using windows

    $JBOSS_HOME/bin/standalone.bat

To deploy the application, you first need to produce the archive to deploy using
the following Maven goal:

    mvn package

You can now deploy the artifact to JBoss AS by executing the following command:

    mvn jboss-as:deploy

This will deploy `warsztaty.war`.

The application will be running at the following URL <http://localhost:8080/warsztaty/welcomePage.xhtml/>.

To undeploy from JBoss AS, run this command:

    mvn jboss-as:undeploy

You can also start JBoss AS 6 and deploy the project using Eclipse. See the JBoss AS 6
Getting Started Guide for Developers for more information.

5. IMPORTING THE PROJECT INTO IDE

---

If you created the project using the Maven archetype wizard in your IDE
(Eclipse, NetBeans or IntelliJ IDEA), then there is nothing to do. You should
already have an IDE project.

If you created the project from the commandline using archetype:generate, then
you need to import the project into your IDE. If you are using NetBeans or
IntelliJ IDEA, then all you have to do is open the project as an existing
project. Both of these IDEs recognize Maven projects natively.
