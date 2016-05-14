package yotkaz.thimman.backend.model

abstract class Challange(

        id: Long?,
        name: String,
        description: String,
        subjects: Set<@JvmSuppressWildcards Subject>

) : Activity(id, name, description, subjects)