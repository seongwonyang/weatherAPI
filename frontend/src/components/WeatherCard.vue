<template>
    <div>
    <v-card style="margin-left:100px; margin-bottom:50px; height:350px; width:500px">
    <Weather v-if="false"></Weather>
        <v-card-title>검색결과 - {{location}} ({{date}})</v-card-title>
            <v-card-text>
                <div>
                    <v-img
                        style="height:250px;"
                        :src="weatherBg"
                    >
                        <div style="font-size:70px; margin:50px 0 50px 20px;">
                            <div v-if="precipitation<25">
                                <span style="color:gold" class="mdi mdi-white-balance-sunny"></span>
                            </div>
                            <div v-else-if="precipitation && precipitation<70">
                                <span style="color:grey" class="mdi mdi-weather-cloudy"></span>
                            </div>
                            <div v-else-if="precipitation">
                                <span style="color:navy" class="mdi mdi-weather-pouring"></span>
                            </div>
                        </div>

                        <div style="font-size:25px; font-weight:500; margin-left:20px; color:white;">
                                온도 {{degree}}&nbsp;<v-icon x-large color="white">mdi-temperature-celsius</v-icon>&nbsp;&nbsp;
                                풍속 {{wind}}km/h&nbsp;<v-icon x-large color="white">mdi-weather-windy-variant</v-icon><br>
                                강수확률 {{precipitation}}%&nbsp;<v-icon x-large color="white">mdi-umbrella</v-icon>&nbsp;&nbsp;
                                습도 {{humidity}}%&nbsp;<v-icon x-large color="white">mdi-weather-rainy</v-icon>
                        </div>
                    </v-img>
                </div>
            </v-card-text>
        </v-card>
    </div>
</template>

<script>
    import Weather from './Weather.vue';
    
    export default {
        name: 'WeatherCard',
        components:{Weather},
        props: {
            date: String,
            location: String,
            degree: Number,
            precipitation: Number,
            humidity: Number,
            wind: Number,
            weatherBg: String,
        },
        data: () => ({
        }),
        methods: {
        },
    }
</script>

