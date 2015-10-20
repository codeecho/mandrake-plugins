package uk.co.codeecho.mandrake.plugins.crust.task;

import uk.co.codeecho.crust.core.EntityManagerFactory;
import uk.co.codeecho.crust.core.EntityManagerImpl;
import uk.co.codeecho.crust.core.EntityManagerNotFoundException;
import uk.co.codeecho.crust.core.dao.mongo.MongoDao;
import uk.co.codeecho.crust.core.mapping.json.DataBackedObjectMapper;
import com.github.fakemongo.Fongo;
import uk.co.codeecho.mandrake.core.task.Task;

public class SetupInMemoryEntityManagerTask implements Task{

    @Override
    public void run() {
        try{
            EntityManagerFactory.getManager();
        }catch(EntityManagerNotFoundException ex){
            EntityManagerFactory.setManager(new EntityManagerImpl(new MongoDao(new Fongo("Mandrake Server").getDB("mandrake"), new DataBackedObjectMapper())));
        }
    }

}
