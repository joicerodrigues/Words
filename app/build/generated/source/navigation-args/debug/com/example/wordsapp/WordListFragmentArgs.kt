package com.example.wordsapp

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class WordListFragmentArgs(
  public val letter: String
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("letter", this.letter)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("letter", this.letter)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): WordListFragmentArgs {
      bundle.setClassLoader(WordListFragmentArgs::class.java.classLoader)
      val __letter : String?
      if (bundle.containsKey("letter")) {
        __letter = bundle.getString("letter")
        if (__letter == null) {
          throw IllegalArgumentException("Argument \"letter\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"letter\" is missing and does not have an android:defaultValue")
      }
      return WordListFragmentArgs(__letter)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): WordListFragmentArgs {
      val __letter : String?
      if (savedStateHandle.contains("letter")) {
        __letter = savedStateHandle["letter"]
        if (__letter == null) {
          throw IllegalArgumentException("Argument \"letter\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"letter\" is missing and does not have an android:defaultValue")
      }
      return WordListFragmentArgs(__letter)
    }
  }
}
