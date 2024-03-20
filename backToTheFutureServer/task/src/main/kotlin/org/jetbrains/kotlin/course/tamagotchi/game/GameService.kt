package org.jetbrains.kotlin.course.tamagotchi.game

import org.jetbrains.kotlin.course.tamagotchi.models.Command
import org.jetbrains.kotlin.course.tamagotchi.models.Mode
import org.springframework.stereotype.Service

@Service
class GameService {
    companion object {
        private const val MAX_CAPACITY = 16
    }

    val commands: ArrayDeque<Command> = ArrayDeque()


    fun addCommand(command: Command): Boolean {
        if (commands.size >= MAX_CAPACITY) {
            return false // If reached max capacity, return false
        }
        commands.add(command) // Add command to the deque
        return true
    }


    fun getCommand(mode: Mode): Command? {
        return when (mode) {
            Mode.Stack -> commands.removeLastOrNull()
            Mode.Queue -> commands.removeFirstOrNull()
        }
    }
}
