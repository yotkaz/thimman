package yotkaz.thimman.backend.model.base

import yotkaz.thimman.backend.app.DEFAULT_STRING
import yotkaz.thimman.backend.app.JPA_EMPTY_CONSTRUCTOR
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Question(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        var name: String,
        var comment: String,
        var answers: Set<String> = HashSet(),
        correctAnswers: List<String> = ArrayList(),
        var requiredSkills: Set<Skill> = HashSet()

) {

    var correctAnswers: List<String> = ArrayList()
        set(newCorrectAnswers) {
            if (answers.containsAll(newCorrectAnswers)) {
                field = newCorrectAnswers;
            } else {
                throw IllegalArgumentException("Correct answers must be a subset of possible answers!");
            }
        }

    init {
        this.correctAnswers = correctAnswers;
    }

    @Deprecated(JPA_EMPTY_CONSTRUCTOR)
    constructor() : this(
            name = DEFAULT_STRING,
            comment = DEFAULT_STRING
    )

}