package usecases

import entities.Question

class CalculateResult {
    fun execute(questions: List<Question>, answers: List<Int?>): Int {
        return questions.zip(answers).count { (question, answer) ->
            answer != null && question.correctAnswerIndex == answer
        }
    }
}
