package usecases

import entities.Player
import entities.Question
import entities.Quiz
import repositories.QuizRepository

class StartQuiz(private val quizRepository: QuizRepository) {
    fun execute(player: Player, domain: String): Quiz {
        return quizRepository.getQuizByDomain(domain)
    }
}
