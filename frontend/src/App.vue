

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                        날씨 조회 API
                    </span>
                </v-toolbar-title>
                <v-spacer></v-spacer>
            </v-app-bar>

            <v-navigation-drawer app clipped flat>
                <v-list>


                    <v-list-item
                        class="px-2"
                        key="weathers"
                        to="/"
                        color="deep-purple lighten-2"
                        style="font-weight:700;"
                    >
                        Weather
                    </v-list-item>




                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container class="py-8 px-6" fluid>
                <form>
                    <v-text-field
                        v-model="keyword"
                        :counter="10"
                        label="날씨 조회"
                        required
                    ></v-text-field>

                    <v-btn
                        class="mr-4"
                        @click="searchWeather()"
                    >
                        submit
                    </v-btn>
                </form>
                <br>
                <router-view v-bind:result="result" v-bind:weatherBg="weatherBg"></router-view>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>
const axios = require('axios').default;

export default {
    name: "App",

    components: {},

    data: () => ({
        keyword: "",
        result: [],
        weatherBg: "",
    }),

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        async searchWeather() {
            var me = this

            me.result = []
            axios.get(`/weathers/search/${this.keyword}`).then(function(response){

                me.result.push(response.data)

                console.log(me.result[0][0])
                console.log(me.result[0][1])

                if(!response.data[0]){
                    alert("해당 지역의 정보가 없습니다.")
                    return false
                }

                for(var i=0; i<me.result[0].length; i++){
                    if(me.result[0][i].precipitation<25) {
                        me.result[0][i].weatherBg = "https://user-images.githubusercontent.com/92732781/174241118-7832da47-bbb8-481c-a11a-737a6b986104.png";
                    } else if(me.result[0][i].precipitation>=25 && me.result[0][i].precipitation<70) {
                        me.result[0][i].weatherBg = "https://user-images.githubusercontent.com/92732781/174242976-3f6d5bda-7bcb-404b-a299-84961e2f0c54.png";
                    } else if(me.result[0][i].precipitation>=70) {
                        me.result[0][i].weatherBg = "https://user-images.githubusercontent.com/92732781/174243446-886452db-083a-4882-b02e-efd577ce17f6.png";
                    }
                }

                console.log(me.result[0])



            }).catch(function (error) {
                console.log(error)
                alert("일시적인 오류가 발생하였습니다.")
            });
        },
    }
};
</script>
<style>
</style>
