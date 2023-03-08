package br.com.marvelapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.marvelapi.databinding.FragmentAllCharactersBinding

class AllCharactersFragment : Fragment(), CharacterAdapter.OnItemClickListener {

    private var _binding: FragmentAllCharactersBinding? = null
    private val binding get() = _binding!!

    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(
            listOf(
                CharacterModel(
                    name = "Name",
                    description = "Description",
                    thumbnail = R.drawable.logo
                ),
                CharacterModel(
                    name = "Name",
                    description = "Description",
                    thumbnail = R.drawable.logo
                ),
                CharacterModel(
                    name = "Name",
                    description = "Description",
                    thumbnail = R.drawable.logo
                ),
                CharacterModel(
                    name = "Name",
                    description = "Description",
                    thumbnail = R.drawable.logo
                ),
                CharacterModel(
                    name = "Name",
                    description = "Description",
                    thumbnail = R.drawable.logo
                )
            )
        )
    }

    private fun setupRecyclerView(characterList: List<CharacterModel> = mutableListOf()) {
        characterAdapter = CharacterAdapter(characterList, this)
        binding.rvCharacters.layoutManager = LinearLayoutManager(context)
        binding.rvCharacters.setHasFixedSize(true)
        binding.rvCharacters.adapter = characterAdapter
    }

    override fun show(position: Int) {
        findNavController().navigate(R.id.action_allCharactersFragment_to_characterDetailsFragment)
    }
}