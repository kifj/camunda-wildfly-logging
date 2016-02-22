package org.camunda.bpm.application.impl.logging;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.MDC;

public class EndEventListener implements ExecutionListener {

  @Override
  public void notify(DelegateExecution execution) {
    MDC.remove("businessKey");
    MDC.remove("processInstanceId");
    MDC.remove("activityId");
    MDC.remove("processDefinitionId");
  }

}
