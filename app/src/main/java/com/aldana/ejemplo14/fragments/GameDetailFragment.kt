package com.aldana.ejemplo14.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.aldana.ejemplo14.R
import com.aldana.ejemplo14.activities.GameDTO
import kotlinx.android.synthetic.main.fragment_game_detail.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GameDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GameDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GameDetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var game = GameDTO()
    private lateinit var fragmentView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_game_detail, container, false)
        fragmentView = view

        bindData()

        return view
    }

    fun bindData(){
        fragmentView.equipoA.text = game.equipoA
        fragmentView.equipoB.text = game.equipoB
        fragmentView.puntos_equipoA.text = game.puntosEquipoA.toString()
        fragmentView.puntos_equipoB.text = game.puntosEquipoB.toString()
    }

    companion object {
        @JvmStatic
        fun newInstance(partido: GameDTO): GameDetailFragment{
            val newFragment = GameDetailFragment()
            newFragment.game = partido

            return newFragment
        }
    }
}
