package br.com.marvelapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.marvelapi.databinding.ItemCharacterBinding
import com.bumptech.glide.Glide

class CharacterAdapter(var characterList: List<CharacterModel>, private var listener: OnItemClickListener) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){

    interface OnItemClickListener {
        fun show(position: Int)
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root){

            fun bind(characterModel: CharacterModel) = with(itemView) {

                binding.tvNameCharacter.text = characterModel.name
                binding.tvDescriptionCharacter.text = characterModel.description
                Glide.with(this)
                    .load("${characterModel.thumbnail.path}.${characterModel.thumbnail.extension}")
                    .into(binding.imgCharacter)
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

        holder.itemView.setOnClickListener {
            listener.show(position)
        }
    }

    override fun getItemCount() = characterList.size

}