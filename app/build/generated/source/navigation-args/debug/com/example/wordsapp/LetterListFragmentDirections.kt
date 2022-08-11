package com.example.wordsapp

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String

public class LetterListFragmentDirections private constructor() {
  private data class ActionLetterListFragmentToWordListFragment(
    public val letter: String
  ) : NavDirections {
    public override val actionId: Int = R.id.action_letterListFragment_to_wordListFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("letter", this.letter)
        return result
      }
  }

  public companion object {
    public fun actionLetterListFragmentToWordListFragment(letter: String): NavDirections =
        ActionLetterListFragmentToWordListFragment(letter)
  }
}
