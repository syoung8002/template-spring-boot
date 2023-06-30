import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

const themeColors = {
    surface:'{{options.rootModel.uiStyle.palette.colors.surface.colorCode}}',
    primary: '{{options.rootModel.uiStyle.palette.colors.primary.colorCode}}',
    'primary-darken-1': '{{options.rootModel.uiStyle.palette.colors.primary-darken-1.colorCode}}',
    secondary: '{{options.rootModel.uiStyle.palette.colors.secondary.colorCode}}',
    'secondary-darken-1': '{{options.rootModel.uiStyle.palette.colors.secondary-darken-1.colorCode}}',
    info: '{{options.rootModel.uiStyle.palette.colors.info.colorCode}}',
    error: '{{options.rootModel.uiStyle.palette.colors.error.colorCode}}',
    warning: '{{options.rootModel.uiStyle.palette.colors.warning.colorCode}}',
    success: '{{options.rootModel.uiStyle.palette.colors.success.colorCode}}',
};

const defaultColors = {
    surface: '#FFFFFF',
    primary: '#1976D2',
    'primary-darken-1': '#1565C0',
    secondary: '#424242',
    'secondary-darken-1': '#212121',
    info: '#2196F3',
    error: '#FF5252',
    warning: '#FFC107',
    success: '#4CAF50',
};

Object.keys(themeColors).forEach(key => {
    if (!themeColors[key]) {
        themeColors[key] = defaultColors[key];
    }
});

export default new Vuetify({
    theme: {
        light: true,
        themes: {
            light: themeColors,
        },
    },
});
