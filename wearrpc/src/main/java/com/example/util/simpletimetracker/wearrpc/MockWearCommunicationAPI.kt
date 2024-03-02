package com.example.util.simpletimetracker.wearrpc

class MockWearCommunicationAPI : WearCommunicationAPI {

    var activities: List<Activity> = emptyList()
    var currentActivities: List<CurrentActivity> = emptyList()
    var tags: Map<Long, List<Tag>> = mapOf()
    lateinit var settings: Settings

    override suspend fun queryActivities(): List<Activity> {
        return activities
    }

    fun mock_queryActivities(activities: List<Activity>) {
        this.activities = activities
    }

    override suspend fun queryCurrentActivities(): List<CurrentActivity> {
        return currentActivities
    }

    fun mock_queryCurrentActivities(activities: List<CurrentActivity>) {
        this.currentActivities = activities
    }

    override suspend fun setCurrentActivities(activities: List<CurrentActivity>) {
        TODO("Not yet implemented")
    }

    override suspend fun queryTagsForActivity(activityId: Long): List<Tag> {
        return this.tags[activityId].orEmpty()
    }

    fun mock_queryTagsForActivity(tags: Map<Long, List<Tag>>) {
        this.tags = tags
    }

    override suspend fun querySettings(): Settings {
        return settings
    }

    fun mock_querySettings(settings: Settings) {
        this.settings = settings
    }

    fun mockReset() {
        this.activities = emptyList()
        this.currentActivities = emptyList()
        this.tags = mapOf()
    }

}