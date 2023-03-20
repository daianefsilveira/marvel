package br.com.marvelapi.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapi.CharacterModel
import br.com.marvelapi.R
import br.com.marvelapi.databinding.ItemCharacterBinding
import com.bumptech.glide.Glide

class CharacterAdapter(var characterList: List<CharacterModel>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root){

            fun bind(characterModel: CharacterModel) = with(itemView) {

                binding.tvNameCharacter.text = characterModel.name
                binding.tvDescriptionCharacter.text = characterModel.description
                Glide.with(this)
                    .load("${characterModel.thumbnail.path}.${characterModel.thumbnail.extension}")
                    .into(binding.imgCharacter)

                binding.root.setOnClickListener {
                    findNavController().navigate(
                        R.id.characterDetailsFragment,
                        sendBundle(characterModel.id)
                    )
                }
            }

        private fun sendBundle(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt("data", id)
            return bundle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemCharacterBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])

    }

    override fun getItemCount() = characterList.size

}