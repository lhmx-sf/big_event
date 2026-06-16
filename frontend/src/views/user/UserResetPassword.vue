<script setup>
import { ref } from 'vue'
import { ElMessage } from 'element-plus'

const form = ref({
    old_Pwd: '',
    new_Pwd: '',
    re_Pwd: ''
})

const rules = {
    old_Pwd: [
        { required: true, message: '请输入原密码', trigger: 'blur' },
        { pattern: /^\S{5,16}$/, message: '密码格式不正确', trigger: 'blur' }
    ],
    new_Pwd: [
        { required: true, message: '请输入新密码', trigger: 'blur' },
        { pattern: /^\S{5,16}$/, message: '密码格式不正确', trigger: 'blur' }
    ],
    re_Pwd: [
        { required: true, message: '请确认新密码', trigger: 'blur' },
        { pattern: /^\S{5,16}$/, message: '密码格式不正确', trigger: 'blur' }
    ]
}

import request from '@/utils/request.js'
import { useRouter } from 'vue-router'
const router = useRouter()

const updatePassword = async () => {
    let result = await request.patch('/user/updatePwd', form.value)
    ElMessage.success(result.msg ? result.msg : '修改成功')
    router.push('/login')
}
</script>

<template>
    <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>重置密码</span>
            </div>
        </template>
        <el-row>
            <el-col :span="12">
                <el-form :model="form" :rules="rules" label-width="100px" size="large">
                    <el-form-item label="原密码" prop="old_Pwd">
                        <el-input v-model="form.old_Pwd" type="password" show-password></el-input>
                    </el-form-item>
                    <el-form-item label="新密码" prop="new_Pwd">
                        <el-input v-model="form.new_Pwd" type="password" show-password></el-input>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="re_Pwd">
                        <el-input v-model="form.re_Pwd" type="password" show-password></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="updatePassword">提交修改</el-button>
                    </el-form-item>
                </el-form>
            </el-col>
        </el-row>
    </el-card>
</template>
