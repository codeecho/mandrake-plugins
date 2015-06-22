package uk.co.codeecho.mandrake.plugins.crust.task;

import biz.devspot.entity.framework.core.EntityManagerFactory;
import uk.co.codeecho.mandrake.core.task.Task;

public abstract class TransactionalTask implements Task{

    @Override
    public void run() {
        EntityManagerFactory.getManager().openTransaction();
        doRun();
        EntityManagerFactory.getManager().commitTransaction();
    }
    
    public abstract void doRun();

}
