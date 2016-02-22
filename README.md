camunda-wildfly-logging
=======================

a logging extension plugin for Camunda BPM.

Compile the jar file with maven: `mvn package`

Modify the JBoss configuration by copying the jar file to `modules/org/camunda/bpm/wildfly/camunda-wildfly-subsystem/main` edit `module.xml`:

<pre>
&lt;module xmlns="urn:jboss:module:1.0" name="org.camunda.bpm.wildfly.camunda-wildfly-subsystem"&gt;
  &lt;resources&gt;
    &lt;resource-root path="camunda-wildfly-subsystem-7.4.0.jar" /&gt;
    &lt;resource-root path="camunda-wildfly-logging-7.4.0.jar" /&gt;
  &lt;/resources&gt;
...
  &lt;module name="org.slf4j" /&gt;
&lt;/module&gt;
</pre>

Add the LoggingEventListenerPlugin at the end of the plugins (important!) of the camunda engine:

<pre>
&lt;subsystem xmlns="urn:org.camunda.bpm.jboss:1.1"&gt;
  &lt;process-engines>
    &lt;process-engine name="default" default="true"&gt;
      &lt;plugins&gt;
        &lt;plugin&gt;
          &lt;class&gt;org.camunda.bpm.application.impl.event.ProcessApplicationEventListenerPlugin&lt;/class&gt;
        &lt;/plugin&gt;
        &lt;plugin&gt;
          &lt;class&gt;org.camunda.spin.plugin.impl.SpinProcessEnginePlugin&lt;/class&gt;
        &lt;/plugin&gt;
        &lt;plugin&gt;
          &lt;class&gt;org.camunda.connect.plugin.impl.ConnectProcessEnginePlugin&lt;/class&gt;
        &lt;/plugin&gt;
        &lt;plugin&gt;
          &lt;class&gt;org.camunda.bpm.application.impl.logging.LoggingEventListenerPlugin&lt;/class&gt;
        &lt;/plugin&gt;
      &lt;/plugins&gt;
    &lt;/plugins&gt;
    ...
</pre>

When combined with JSON logging from https://github.com/kifj/wildfly-logstash you can produce log files (e.g. for ELK) which contain MDC fields like:

<pre>
{ 
  ... 
  "@mdc":  {
    "activityId": "validateVacationRequest", 
    "processInstanceId":"ef95ecf5-d0bb-11e5-bdc7-002314a4d3d9",
    "businessKey":"2",
    "processDefinitionId":"vacationRequest:1:173a5a58-d0bb-11e5-bdc7-002314a4d3d9"
  }
 }
</pre>
