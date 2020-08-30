# migrosDemo
Hi this is my demo Application  , created in intelliJ community edition with maven so you might need some configurations to run it in your pc.

1-)You have to have apache-tomcat ,apache-ant in your pc and their environment variables CATALINA_HOME && ANT_HOME respectively which are pointing their folders.Then you must add to your system PATH variable %ANT_HOME%\bin and %CATALINA_HOME%\bin . (Assuming you already have a jdk installed in your pc and have JAVA_HOME)

2-)In this project i used mariadb with username=root and password:123456 and db name as test hardcoded in web-servlet.If you would like to change the following settings in the following files;

HelloWeb-Servlet.xml

<bean id="ds" class="org.springframework.jdbc.datasource.DriverManagerDataSource"> 
        <property name="driverClassName" value="org.mariadb.jdbc.Driver"/>
        <property name="url" value="jdbc:mariadb://localhost:3306/test"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </bean>
    
if you are going to use another db rather than mariaDb then you need to add its dependenct to pom.xml

3-)There are certain sql script you need to execute before running the app which i shared as "scripts.sql" in this repo.

4-)Finally in intellijCommunity i use smartTomcat plugin since spring support is only in intellij premium so it needs to be installed to your ide as a plugin and configured as shown in the demonstration video which i also uploaded in this repo.Or you might want to configure another tomcat server if you wish...

Thank your for your interest.
