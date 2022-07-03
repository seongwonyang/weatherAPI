<template>

    <div style="display:flex !important;">
        <App v-if="false"></App>
        <v-card style="width:450px; height:950px" outlined>
            <template slot="progress">
                <v-progress-linear
                        color="deep-purple"
                        height="10"
                        indeterminate
                ></v-progress-linear>
            </template>

            <v-card-title>
                Input Weather Data
            </v-card-title >

            <v-card-text>
                <v-form
                    ref="form"
                    lazy-validation
                >

                    <v-date-picker v-model="date"></v-date-picker>
                    <v-text-field
                        v-model="date"
                        label="날짜"
                        readonly
                    ></v-text-field>

                    <v-text-field
                        v-model="location"
                        label="지역"
                    ></v-text-field>

                    <v-text-field
                        v-model="degree"
                        label="기온"
                        type="number"
                    ></v-text-field>

                    <v-text-field
                        v-model="precipitation"
                        label="강수확률"
                        type="number"
                    ></v-text-field>

                    <v-text-field
                        v-model="humidity"
                        label="습도"
                        type="number"
                    ></v-text-field>

                    <v-text-field
                        v-model="wind"
                        label="풍속"
                        type="number"
                    ></v-text-field>

                    <v-btn
                        color="success"
                        class="mr-4"
                        @click="save"
                        >
                        save
                    </v-btn>
                </v-form>
            </v-card-text>
        </v-card>
        <div style="display: table-cell">
            <div v-for="(data,idx) in result[0]" :key="idx">
                <WeatherCard :degree="data.degree" :wind="data.wind" :precipitation="data.precipitation"
                    :humidity="data.humidity" :location="data.location" :date="data.date" :weatherBg="data.weatherBg"></WeatherCard>
            </div>
        </div>
        <!-- <v-card style="margin-left:100px; height:350px; width:500px" v-if="result[0]">
            <v-card-title>검색결과 - {{result[0].location}} ({{result[0].date}})</v-card-title>
            <v-card-text>
                <div>
                    <v-img
                        style="height:250px;"
                        :src="weatherBg"
                    >
                        <div style="font-size:70px; margin:50px 0 50px 20px;">
                            <div v-if="result[0].precipitation<25">
                                <span style="color:gold" class="mdi mdi-white-balance-sunny"></span>
                            </div>
                            <div v-else-if="25<=result[0].precipitation && result[0].precipitation<70">
                                <span style="color:grey" class="mdi mdi-weather-cloudy"></span>
                            </div>
                            <div v-else-if="70<=result[0].precipitation">
                                <span style="color:navy" class="mdi mdi-weather-pouring"></span>
                            </div>
                        </div>

                        <div style="font-size:25px; font-weight:500; margin-left:20px; color:white;">
                                온도 {{result[0].degree }}&nbsp;<v-icon x-large color="white">mdi-temperature-celsius</v-icon>&nbsp;&nbsp;
                                풍속 {{result[0].wind }}km/h&nbsp;<v-icon x-large color="white">mdi-weather-windy-variant</v-icon><br>
                                강수확률 {{result[0].precipitation }}%&nbsp;<v-icon x-large color="white">mdi-umbrella</v-icon>&nbsp;&nbsp;
                                습도 {{result[0].humidity }}%&nbsp;<v-icon x-large color="white">mdi-weather-rainy</v-icon>
                        </div>
                    </v-img>
                </div>
            </v-card-text>
        </v-card> -->
    </div>
</template>

<script>
    const axios = require('axios').default;
    import App from './../App.vue';
    import WeatherCard from './WeatherCard.vue';
    
    export default {
        name: 'Weather',
        components:{App, WeatherCard},
        props: {
            result: Array,
        },
        data: () => ({
            date: "",
            location: "",
            degree: 0,
            precipitation: 0,
            humidity: 0,
            wind: 0,
        }),
        methods: {
            async save(){
                var me = this
                axios.post(`/weathers`,{date: me.date, location: me.location, degree: me.degree, precipitation: me.precipitation, humidity: me.humidity, wind: me.wind}).then(function () {
                    
                    alert("Insert Weather data")
                    me.date = ""
                    me.location = ""
                    me.degree = 0
                    me.precipitation = 0
                    me.humidity = 0
                    me.wind = 0
                })
            },
        },
    }
</script>

