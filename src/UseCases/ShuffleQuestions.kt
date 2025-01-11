package usecases

import entities.Question

class ShuffleQuestions {
    fun execute(questions: List<Question>): List<Question> {
        return questions.shuffled()
    }
}
