var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "6188",
        "ok": "6188",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "6497",
        "ok": "6497",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "63",
        "ok": "63",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "311",
        "ok": "311",
        "ko": "-"
    },
    "percentiles1": {
        "total": "17",
        "ok": "17",
        "ko": "-"
    },
    "percentiles2": {
        "total": "51",
        "ok": "51",
        "ko": "-"
    },
    "percentiles3": {
        "total": "201",
        "ok": "201",
        "ko": "-"
    },
    "percentiles4": {
        "total": "458",
        "ok": "458",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 6153,
    "percentage": 99
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 6,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 29,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "101.443",
        "ok": "101.443",
        "ko": "-"
    }
},
contents: {
"req_post-deposit-re-d4083": {
        type: "REQUEST",
        name: "post-deposit-request",
path: "post-deposit-request",
pathFormatted: "req_post-deposit-re-d4083",
stats: {
    "name": "post-deposit-request",
    "numberOfRequests": {
        "total": "3094",
        "ok": "3094",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "3",
        "ok": "3",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "6497",
        "ok": "6497",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "105",
        "ok": "105",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "434",
        "ok": "434",
        "ko": "-"
    },
    "percentiles1": {
        "total": "34",
        "ok": "34",
        "ko": "-"
    },
    "percentiles2": {
        "total": "73",
        "ok": "73",
        "ko": "-"
    },
    "percentiles3": {
        "total": "268",
        "ok": "268",
        "ko": "-"
    },
    "percentiles4": {
        "total": "830",
        "ok": "830",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 3060,
    "percentage": 99
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 5,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 29,
    "percentage": 1
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "50.721",
        "ok": "50.721",
        "ko": "-"
    }
}
    },"req_check-balance-a-76d8a": {
        type: "REQUEST",
        name: "check balance after deposit",
path: "check balance after deposit",
pathFormatted: "req_check-balance-a-76d8a",
stats: {
    "name": "check balance after deposit",
    "numberOfRequests": {
        "total": "3094",
        "ok": "3094",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "0",
        "ok": "0",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "897",
        "ok": "897",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "21",
        "ok": "21",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "46",
        "ok": "46",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2",
        "ok": "2",
        "ko": "-"
    },
    "percentiles2": {
        "total": "17",
        "ok": "17",
        "ko": "-"
    },
    "percentiles3": {
        "total": "110",
        "ok": "110",
        "ko": "-"
    },
    "percentiles4": {
        "total": "210",
        "ok": "210",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 3093,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 0,
    "percentage": 0
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "50.721",
        "ok": "50.721",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
