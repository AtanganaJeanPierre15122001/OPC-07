package repositories

import entities.Quiz

interface QuizRepository {
    fun getQuizByDomain(domain: String): Quiz
}
