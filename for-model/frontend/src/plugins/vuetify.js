import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        dark: true,
        primary: {{ options.rootModel.uiStyle.palette.colors.primary.colorCode }}
    }
});
