package dev.example.myplanetapp.model

import com.google.firebase.storage.StorageReference

class VolunteeringEvent(var id: String? = null,
                        var title: String? = null,
                        var time: String? = null,
                        var spots: Int? = null,
                        var picture: String? = null
){}