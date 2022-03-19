var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2400",
        "ok": "2359",
        "ko": "41"
    },
    "minResponseTime": {
        "total": "130",
        "ok": "130",
        "ko": "60000"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "59993",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "34488",
        "ok": "34045",
        "ko": "60000"
    },
    "standardDeviation": {
        "total": "18677",
        "ok": "18530",
        "ko": "0"
    },
    "percentiles1": {
        "total": "40559",
        "ok": "40220",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "50509",
        "ok": "49992",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "58628",
        "ok": "57942",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60000",
        "ok": "59586",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 24,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 15,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2320,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 41,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "24",
        "ok": "23.59",
        "ko": "0.41"
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
        "total": "2400",
        "ok": "2359",
        "ko": "41"
    },
    "minResponseTime": {
        "total": "130",
        "ok": "130",
        "ko": "60000"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "59993",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "34488",
        "ok": "34045",
        "ko": "60000"
    },
    "standardDeviation": {
        "total": "18677",
        "ok": "18530",
        "ko": "0"
    },
    "percentiles1": {
        "total": "40559",
        "ok": "40220",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "50509",
        "ok": "49992",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "58628",
        "ok": "57942",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60000",
        "ok": "59586",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 24,
    "percentage": 1
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 15,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2320,
    "percentage": 97
},
    "group4": {
    "name": "failed",
    "count": 41,
    "percentage": 2
},
    "meanNumberOfRequestsPerSecond": {
        "total": "24",
        "ok": "23.59",
        "ko": "0.41"
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
