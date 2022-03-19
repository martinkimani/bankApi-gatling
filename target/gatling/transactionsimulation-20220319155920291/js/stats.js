var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "3000",
        "ok": "2999",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "21",
        "ok": "21",
        "ko": "60000"
    },
    "maxResponseTime": {
        "total": "60000",
        "ok": "42767",
        "ko": "60000"
    },
    "meanResponseTime": {
        "total": "13973",
        "ok": "13957",
        "ko": "60000"
    },
    "standardDeviation": {
        "total": "11492",
        "ok": "11463",
        "ko": "0"
    },
    "percentiles1": {
        "total": "12243",
        "ok": "12234",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "24826",
        "ok": "24819",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "31900",
        "ok": "31886",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "33367",
        "ok": "33364",
        "ko": "60000"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 527,
    "percentage": 18
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 87,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2385,
    "percentage": 80
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "36.585",
        "ok": "36.573",
        "ko": "0.012"
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
        "total": "3000",
        "ok": "2999",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "21",
        "ok": "21",
        "ko": "60000"
    },
    "maxResponseTime": {
        "total": "60000",
        "ok": "42767",
        "ko": "60000"
    },
    "meanResponseTime": {
        "total": "13973",
        "ok": "13957",
        "ko": "60000"
    },
    "standardDeviation": {
        "total": "11492",
        "ok": "11463",
        "ko": "0"
    },
    "percentiles1": {
        "total": "12239",
        "ok": "12233",
        "ko": "60000"
    },
    "percentiles2": {
        "total": "24826",
        "ok": "24819",
        "ko": "60000"
    },
    "percentiles3": {
        "total": "31900",
        "ok": "31886",
        "ko": "60000"
    },
    "percentiles4": {
        "total": "33367",
        "ok": "33364",
        "ko": "60000"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 527,
    "percentage": 18
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 87,
    "percentage": 3
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 2385,
    "percentage": 80
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "36.585",
        "ok": "36.573",
        "ko": "0.012"
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
