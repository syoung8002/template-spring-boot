import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

export default new Vuetify({
    theme: {
        light: true,
        themes: {
            light: {
                surface:'{{options.rootModel.uiStyle.palette.colors.surface.colorCode}}',
                primary: '{{options.rootModel.uiStyle.palette.colors.primary.colorCode}}',
                'primary-darken-1': '{{options.rootModel.uiStyle.palette.colors.primary-darken-1.colorCode}}',
                secondary: '{{options.rootModel.uiStyle.palette.colors.secondary.colorCode}}',
                'secondary-darken-1': '{{options.rootModel.uiStyle.palette.colors.secondary-darken-1.colorCode}}',
                info: '{{options.rootModel.uiStyle.palette.colors.info.colorCode}}',
                error: '{{options.rootModel.uiStyle.palette.colors.error.colorCode}}',
                warning: '{{options.rootModel.uiStyle.palette.colors.warning.colorCode}}',
                success: '{{options.rootModel.uiStyle.palette.colors.success.colorCode}}',
            },
        },
    },
});
