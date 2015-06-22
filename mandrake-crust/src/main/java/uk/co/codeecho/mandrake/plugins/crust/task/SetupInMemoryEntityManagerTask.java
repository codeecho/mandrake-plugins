package uk.co.codeecho.mandrake.plugins.crust.task;

import biz.devspot.entity.framework.core.EntityManagerFactory;
import biz.devspot.entity.framework.core.EntityManagerImpl;
import biz.devspot.entity.framework.core.EntityManagerNotFoundException;
import biz.devspot.entity.framework.core.dao.mongo.MongoDao;
import biz.devspot.entity.framework.core.mapping.json.DataBackedObjectMapper;
import com.github.fakemongo.Fongo;
import uk.co.codeecho.mandrake.core.task.Task;

public abstract class SetupInMemoryEntityManagerTask implements Task{

    @Override
    public void run() {
        try{
            EntityManagerFactory.getManager();
        }catch(EntityManagerNotFoundException ex){
            EntityManagerFactory.setManager(new EntityManagerImpl(new MongoDao(new Fongo("Mandrake Server").getDB("mandrake"), new DataBackedObjectMapper())));
        }
    }

}
