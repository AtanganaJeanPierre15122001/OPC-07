package frameworks

import entities.Player
import interfaceadapters.ConsoleController
import interfaceadapters.FileBasedQuizRepository
import usecases.CalculateResult
import usecases.ShuffleQuestions
import usecases.StartQuiz

suspend fun main() {
    val quizRepository = FileBasedQuizRepository("quizzes.txt")
    val controller = ConsoleController()
    val startQuiz = StartQuiz(quizRepository)
    val shuffleQuestions = ShuffleQuestions()
    val calculateResult = CalculateResult()

    val playerName = controller.welcomePlayer()
    val player = Player(playerName)

    while (true) {
        val domains = quizRepository.getAllDomains()
        val domain = controller.selectDomain(domains)
        val quiz = startQuiz.execute(player, domain)
        val shuffledQuestions = shuffleQuestions.execute(quiz.questions)

        val answers = shuffledQuestions.map { question -> controller.askQuestion(question) }
        val score = calculateResult.execute(shuffledQuestions, answers)

        controller.showResult(score, shuffledQuestions.size)
    }
}
