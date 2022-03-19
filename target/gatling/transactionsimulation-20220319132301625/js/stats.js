var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "6000",
        "ok": "1579",
        "ko": "4421"
    },
    "minResponseTime": {
        "total": "158",
        "ok": "158",
        "ko": "60000"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "59994",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "50879",
        "ok": "25341",
        "ko": "60000"
    },
    "standardDeviation": {
        "total": "17620",
        "ok": "17165",
        "ko": "0"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "22605",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "39463",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "55399",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "59113",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 27,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 18,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1534,
    "percentage": 26
},
    "group4": {
    "name": "failed",
    "count": 4421,
    "percentage": 74
},
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "13.158",
        "ko": "36.842"
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
        "total": "6000",
        "ok": "1579",
        "ko": "4421"
    },
    "minResponseTime": {
        "total": "158",
        "ok": "158",
        "ko": "60000"
    },
    "maxResponseTime": {
        "total": "60001",
        "ok": "59994",
        "ko": "60001"
    },
    "meanResponseTime": {
        "total": "50879",
        "ok": "25341",
        "ko": "60000"
    },
    "standardDeviation": {
        "total": "17620",
        "ok": "17165",
        "ko": "0"
    },
    "percentiles1": {
        "total": "60000",
        "ok": "22605",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "60000",
        "ok": "39463",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "60000",
        "ok": "55399",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "60001",
        "ok": "59113",
        "ko": "60001"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 27,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 18,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 1534,
    "percentage": 26
},
    "group4": {
    "name": "failed",
    "count": 4421,
    "percentage": 74
},
    "meanNumberOfRequestsPerSecond": {
        "total": "50",
        "ok": "13.158",
        "ko": "36.842"
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
