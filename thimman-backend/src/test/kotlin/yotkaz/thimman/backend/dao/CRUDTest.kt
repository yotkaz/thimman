package yotkaz.thimman.backend.dao

import org.junit.Assert
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.CrudRepository
import java.io.Serializable

abstract class CRUDTest<ObjectType, IdType, DAOType>
        where DAOType : CrudRepository<ObjectType, IdType>, IdType : Serializable {

    @Autowired
    lateinit var dao: DAOType;

    abstract fun buildObject(): ObjectType;
    abstract fun getObjectId(obj: ObjectType): IdType;
    abstract fun modifyObject(obj: ObjectType): ObjectType;
    abstract fun isRead(obj: ObjectType): Boolean;
    abstract fun isUpdated(obj: ObjectType): Boolean;

    @Test
    fun crud() {
        var obj: ObjectType = buildObject();

        create(obj);
        Assert.assertNotNull(getObjectId(obj));

        obj = read(getObjectId(obj));
        Assert.assertTrue(isRead(obj));

        modifyObject(obj);
        update(obj);
        obj = read(getObjectId(obj));
        Assert.assertTrue(isUpdated(obj));

        delete(obj);
        obj = read(getObjectId(obj));
        Assert.assertNull(obj);
    }

    fun create(obj: ObjectType) {
        dao.save(obj);
    }

    fun read(id: IdType): ObjectType {
        return dao.findOne(id);
    }

    fun update(obj: ObjectType) {
        dao.save(obj);
    }

    fun delete(obj: ObjectType) {
        dao.delete(obj);
    }

}