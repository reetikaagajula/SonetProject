package com.example.sonetproject.utility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sonetproject.R
import com.example.sonetproject.data.User

class UserListAdapter(private val onItemClicked: (position:Int)->Unit) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    var userList = emptyList<User>()
    class UserViewHolder(itemView: View,private val onItemClicked: (position:Int)->Unit): RecyclerView.ViewHolder(itemView),View.OnClickListener{
        init{
            itemView.setOnClickListener(this)
        }
        override fun onClick(v:View){
            val position = adapterPosition
            onItemClicked(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false),onItemClicked)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var currentPos = userList[position]
        var id = holder.itemView.findViewById<TextView>(R.id.id_txt)
        id.text=currentPos.id.toString()

        var firstname = holder.itemView.findViewById<TextView>(R.id.firstName_txt)
        firstname.text=currentPos.firstname.toString()

        var lastname = holder.itemView.findViewById<TextView>(R.id.lastName_txt)
        lastname.text=currentPos.lastname.toString()

        var age = holder.itemView.findViewById<TextView>(R.id.age_txt)
        age.text=currentPos.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setUserData(user:List<User>){
        userList = user
        notifyDataSetChanged()
    }

}