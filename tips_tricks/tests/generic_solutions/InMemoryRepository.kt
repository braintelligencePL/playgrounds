
import org.springframework.data.repository.CrudRepository
import java.io.Serializable
import java.util.*
import java.util.Objects.requireNonNull
import java.util.concurrent.ConcurrentHashMap


interface IdExtractor<T, ID> {
    fun getId(entity: T): ID
}

class InMemoryCrudRepository<ENTITY, ID : Serializable>(idExtractor: IdExtractor<ENTITY, ID>) : CrudRepository<ENTITY, ID> {

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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll(entities: MutableIterable<ENTITY>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteAll() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <S : ENTITY> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun count(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllById(ids: MutableIterable<ID>): MutableIterable<ENTITY> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun existsById(id: ID): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: ID): Optional<ENTITY> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(entity: ENTITY) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
