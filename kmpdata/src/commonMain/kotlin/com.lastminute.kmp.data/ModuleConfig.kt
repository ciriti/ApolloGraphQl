package com.lastminute.kmp.data

interface ModuleConfig {
    var netConfig : NetConfig
}

interface NetConfig{
    var url : String
    var pathDeals : String
}

object NetConfigImpl : NetConfig{
    override var url: String = "services.lastminute.com/getaways-backend"
    override var pathDeals: String = "api/v1/destinations"
}