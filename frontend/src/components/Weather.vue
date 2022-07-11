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

