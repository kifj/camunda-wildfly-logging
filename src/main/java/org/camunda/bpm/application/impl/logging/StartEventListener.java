package org.camunda.bpm.application.impl.logging;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.MDC;

public class StartEventListener implements ExecutionListener {
  
  @Override
  public void notify(DelegateExecution execution) {
    if (execution.getProcessBusinessKey() != null) {
      MDC.put("businessKey", execution.getProcessBusinessKey());
    }
    MDC.put("processInstanceId", execution.getProcessInstanceId());
    MDC.put("activityId", execution.getCurrentActivityId());
    MDC.put("processDefinitionId", execution.getProcessDefinitionId());
  }
  
}
