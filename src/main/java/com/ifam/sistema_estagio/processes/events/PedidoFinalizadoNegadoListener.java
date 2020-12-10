package com.ifam.sistema_estagio.processes.events;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Service;

@Service("pedidoFinalizadoNegadoListener")
public class PedidoFinalizadoNegadoListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        System.out.println("[Banca Negada] Uma banca foi negada! Id do processo: "+ execution.getProcessInstanceId());
        execution.removeVariables();
        execution.removeVariablesLocal();
    }
}
