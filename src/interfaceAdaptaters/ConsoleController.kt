package interfaceadapters

import entities.Question
import kotlin.system.exitProcess

class ConsoleController {
    fun welcomePlayer(): String {
        println("👋 Welcome to the Quiz App!")
        print("Enter your name: ")
        return readln()
    }

    fun selectDomain(domains: List<String>): String {
        println("🎯 Choose a domain:")
        domains.forEachIndexed { index, domain -> println("${index + 1}. $domain") }
        val choice = readln().toIntOrNull()
        return if (choice != null && choice in 1..domains.size) {
            domains[choice - 1]
        } else {
            println("❌ Invalid choice. Exiting.")
            exitProcess(0)
        }
    }

    fun askQuestion(question: Question): Int? {
        println("\n❓ ${question.text}")
        question.options.forEachIndexed { index, option -> println("${index + 1}. $option") }
        print("Your answer (1-4): ")
        val startTime = System.currentTimeMillis()
        val answer = readlnOrNull()?.toIntOrNull()
        if (System.currentTimeMillis() - startTime > 10_000) {
            println("⏰ Time's up!")
            return null
        }
        return answer?.minus(1)
    }

    fun showResult(score: Int, total: Int) {
        println("\n📊 Your score: $score/$total")
        if (score >= 5) {
            println("🎉 You passed!")
        } else {
            println("😢 You failed. Would you like to retry? (y/n)")
            if (readln().lowercase() == "y") return
            else exitProcess(0)
        }
    }
}
