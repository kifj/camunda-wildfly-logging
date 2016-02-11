camunda-wildfly-logging
=======================

Logging extension for Camunda BPM.

Compile the jar file with maven: `mvn package`

Modify the JBoss configuration by copying the jar file to `modules/org/camunda/bpm/wildfly/camunda-wildfly-subsystem/main` and edit `module.xml`:

<pre>
&lt;module xmlns="urn:jboss:module:1.0" name="org.camunda.bpm.wildfly.camunda-wildfly-subsystem"&gt;
  &lt;resources&gt;
    &lt;resource-root path="camunda-wildfly-subsystem-7.4.0.jar" /&gt;
    &lt;resource-root path="camunda-wildfly-logging-7.4.0.jar" /&gt;
  &lt;/resources&gt;
...
&lt;/module&gt;
</pre>
