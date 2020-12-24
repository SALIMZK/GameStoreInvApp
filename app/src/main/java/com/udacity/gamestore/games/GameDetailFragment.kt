package com.udacity.gamestore.games

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.gamestore.R
import com.udacity.gamestore.databinding.FragmentGameDetailBinding


class GameDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentGameDetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game_detail, container, false
        )

        val viewModel: GamesViewModel by activityViewModels()
        binding.saveButton.setOnClickListener {
            if (viewModel.isNewGameValid()) {
                viewModel.addNewGame()
                this.findNavController().popBackStack()
            }
        }

        binding.cancelButton.setOnClickListener {
            viewModel.clearDetail()
            this.findNavController().popBackStack()
        }

        binding.viewModel = viewModel

        return binding.root
    }
}