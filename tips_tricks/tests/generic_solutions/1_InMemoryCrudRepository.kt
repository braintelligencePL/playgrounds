
import org.springframework.data.repository.CrudRepository
import java.io.Serializable
import java.util.*
import java.util.Objects.requireNonNull
import java.util.concurrent.ConcurrentHashMap


interface IdExtractor<T, ID> {
    fun getId(entity: T): ID
}

abstract class InMemoryCrudRepository<ENTITY, ID : Serializable>(idExtractor: IdExtractor<ENTITY, ID>) :
    CrudRepository<ENTITY, ID> {

    private val dataStore = ConcurrentHashMap<ID, ENTITY>()
    private val idExtractor: IdExtractor<ENTITY, ID> = requireNonNull<IdExtractor<ENTITY, ID>>(idExtractor)

    override fun <S : ENTITY> save(entity: S): S {
        val id = idExtractor.getId(entity)
        dataStore.put(id, entity)
        return entity
    }

    override fun findAll(): MutableList<ENTITY> {
        return dataStore.values as MutableList<ENTITY>
    }

    override fun deleteById(id: ID) {
        dataStore.remove(id)
    }

    override fun deleteAll(entities: MutableIterable<ENTITY>) {
        entities.forEach(Consumer<ENTITY> { this.delete(it) })
    }

    override fun deleteAll() {
        dataStore.clear()
    }

    override fun count(): Long {
        return dataStore.size.toLong()
    }

    fun delete(id: ID) {
        dataStore.remove(id)
    }

    fun findOne(id: ID): ENTITY {
        return dataStore.get(id)!!
    }
}
