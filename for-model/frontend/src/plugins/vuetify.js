import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        light: true,
        themes: {
            light: {
                primary: '{{options.rootModel.uiStyle.palette.colors.primary.colorCode}}',
                'primary-darken-1': '{{options.rootModel.uiStyle.palette.colors.primary-darken-1.colorCode}}',
            }
        }
    }
});
