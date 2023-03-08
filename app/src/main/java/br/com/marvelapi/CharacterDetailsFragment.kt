package br.com.marvelapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.marvelapi.databinding.FragmentDetailsCharacterBinding

class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentDetailsCharacterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }
}