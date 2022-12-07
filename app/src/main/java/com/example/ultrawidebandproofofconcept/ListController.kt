package com.example.uwb_poc

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.ultrawidebandproofofconcept.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_bluetooth_device.view.*


class ListController (
    private val BluetoothDeviceList: MutableList<BluetoothDeviceModel>

) : RecyclerView.Adapter<ListController.BluetoothViewHolder>(){
    class BluetoothViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BluetoothViewHolder {
        return BluetoothViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.list_item_bluetooth_device,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BluetoothViewHolder, position: Int) {
        var curBluetoothDevices = this.BluetoothDeviceList[position]
        holder.itemView.apply {
            textView_list_item_bluetooth_device.text = curBluetoothDevices.name

            button_connect_device.setOnClickListener {
                Log.d("console", "clicked on item ${curBluetoothDevices.name}")
            }
        }

        //button_populate

    }

    override fun getItemCount(): Int {
        return BluetoothDeviceList.size
    }

    fun populateList()//for debug only
    {
        for (i in 1..3) {
            val myDevice = BluetoothDeviceModel("BluetoothDevice$i", i.toString())

            addBluetoothDevice(myDevice)
            Log.d("console", "added item ${myDevice.name}")
        }
    }

    fun addBluetoothDevice(device: BluetoothDeviceModel){
        BluetoothDeviceList.add(device)
        notifyItemInserted(BluetoothDeviceList.size - 1)
    }
}