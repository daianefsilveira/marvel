package br.com.marvelapi

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.marvelapi.databinding.FragmentDetailsCharacterBinding
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentDetailsCharacterBinding? = null
    private val binding get() = _binding!!

    private val marvelViewModel: MarvelViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsCharacterBinding.inflate(inflater, container, false)
        marvelViewModel.getCharacter(arguments?.getInt("data")!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserve()
    }

    private fun setupObserve() {
        marvelViewModel.character.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is NetworkResult.Success -> {
                    resource.data?.let { values ->

                        binding.tvNameCharacterDetails.text = values.data.results[0].name
                        binding.tvDescriptionCharacterDetails.text = values.data.results[0].description
                        Glide.with(this)
                            .load("${values.data.results[0].thumbnail.path}.${values.data.results[0].thumbnail.extension}")
                            .into(binding.imgCharacterDetails)
                        values.data.results
                    }
                }
                is NetworkResult.Error -> {
                    resource.message?.let { message ->
                        Log.e(ContentValues.TAG, "Error is: $message")
                    }
                }
                else -> {}
            }
        }
    }
}







