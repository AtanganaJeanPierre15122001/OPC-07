package interfaceadapters

import entities.Question
import entities.Quiz
import repositories.QuizRepository
import java.io.File

class FileBasedQuizRepository(private val fichier: String) : QuizRepository {

    override fun getQuizByDomain(domain: String): Quiz {
        val lines = File(fichier).readLines()
        var foundDomain = false
        val questions = mutableListOf<Question>()

        for (line in lines) {
            if (line.endsWith(":")) {
                foundDomain = line.trimEnd(':') == domain
            } else if (foundDomain && line.isNotBlank()) {
                val parts = line.split("|")
                if (parts.size == 6) {
                    val text = parts[0]
                    val options = parts.subList(1, 5)
                    val correctAnswerIndex = parts[5].toInt()
                    questions.add(Question(text, options, correctAnswerIndex))
                }
                println(questions)
            } else if (foundDomain && line.isBlank()) {
                break
            }
        }

        if (questions.isEmpty()) {
            throw IllegalArgumentException("No questions found for domain: $domain")
        }

        return Quiz(domain, questions)
    }

    fun getAllDomains(): List<String> {
        return File(fichier).readLines()
            .filter { it.endsWith(":") }
            .map { it.trimEnd(':') }
    }
}
