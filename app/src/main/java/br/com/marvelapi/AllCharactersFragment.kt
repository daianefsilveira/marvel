package br.com.marvelapi

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.marvelapi.databinding.FragmentAllCharactersBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AllCharactersFragment : Fragment() {

    private var _binding: FragmentAllCharactersBinding? = null
    private val binding get() = _binding!!

    private lateinit var characterAdapter: CharacterAdapter

    private val marvelListViewModel: MarvelListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        marvelListViewModel.getCharacterList()
        binding.progressCircular.visibility = View.VISIBLE

        setupObserve()
    }

    private fun setupRecyclerView(characterList: List<CharacterModel>) {
        characterAdapter = CharacterAdapter(characterList)
        binding.rvCharacters.layoutManager = LinearLayoutManager(context)
        binding.rvCharacters.setHasFixedSize(true)
        binding.rvCharacters.adapter = characterAdapter
    }

    private fun setupObserve() {
        marvelListViewModel.characterList.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is NetworkResult.Success -> {
                    resource.data?.let { values ->
                        binding.progressCircular.visibility = View.INVISIBLE
                        setupRecyclerView(values.data.results)
                    }
                }
                is NetworkResult.Error -> {
                    binding.progressCircular.visibility = View.INVISIBLE
                    resource.message?.let { message ->
                        Log.e(TAG, "Error is: $message")
                    }
                }
                is NetworkResult.Loading -> {
                    binding.progressCircular.visibility = View.GONE
                }
                else -> {}
            }
        }
    }
}