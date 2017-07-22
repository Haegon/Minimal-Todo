package com.example.avjindersinghsekhon.minimaltodo

import org.json.JSONException
import org.json.JSONObject
import java.io.Serializable
import java.util.*

class ToDoItemKt : Serializable {
    var toDoText: String? = null
    private var mHasReminder: Boolean = false
    //    private Date mLastEdited;
    var todoColor: Int = 0
    var toDoDate: Date? = null
    var identifier: UUID? = null
        private set


    @JvmOverloads constructor(todoBody: String = "Clean my room", hasReminder: Boolean = true, toDoDate: Date = Date()) {
        toDoText = todoBody
        mHasReminder = hasReminder
        this.toDoDate = toDoDate
        todoColor = 1677725
        identifier = UUID.randomUUID()
    }

    @Throws(JSONException::class)
    constructor(jsonObject: JSONObject) {
        toDoText = jsonObject.getString(TODOTEXT)
        mHasReminder = jsonObject.getBoolean(TODOREMINDER)
        todoColor = jsonObject.getInt(TODOCOLOR)
        identifier = UUID.fromString(jsonObject.getString(TODOIDENTIFIER))

        //        if(jsonObject.has(TODOLASTEDITED)){
        //            mLastEdited = new Date(jsonObject.getLong(TODOLASTEDITED));
        //        }
        if (jsonObject.has(TODODATE)) {
            toDoDate = Date(jsonObject.getLong(TODODATE))
        }
    }

    @Throws(JSONException::class)
    fun toJSON(): JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put(TODOTEXT, toDoText)
        jsonObject.put(TODOREMINDER, mHasReminder)
        //        jsonObject.put(TODOLASTEDITED, mLastEdited.getTime());
        if (toDoDate != null) {
            jsonObject.put(TODODATE, toDoDate!!.time)
        }
        jsonObject.put(TODOCOLOR, todoColor)
        jsonObject.put(TODOIDENTIFIER, identifier!!.toString())

        return jsonObject
    }

    fun hasReminder(): Boolean {
        return mHasReminder
    }

    fun setHasReminder(mHasReminder: Boolean) {
        this.mHasReminder = mHasReminder
    }

    companion object {
        private val TODOTEXT = "todotext"
        private val TODOREMINDER = "todoreminder"
        //    private static final String TODOLASTEDITED = "todolastedited";
        private val TODOCOLOR = "todocolor"
        private val TODODATE = "tododate"
        private val TODOIDENTIFIER = "todoidentifier"
    }
}

